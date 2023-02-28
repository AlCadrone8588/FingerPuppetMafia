package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class mecanumTutorial extends LinearOpMode {

    DcMotor frontRight;
    DcMotor frontleft;
    DcMotor backRight;
    DcMotor backleft;
    //mecanum wheels are required in groups of four if you want them to work as intended.

    @Override
    public void runOpMode(){
        frontRight = hardwareMap.dcMotor.get("fr");
        frontleft = hardwareMap.dcMotor.get("fl");
        backRight = hardwareMap.dcMotor.get("br");
        backleft = hardwareMap.dcMotor.get("bl");
        //as a note i usually keep these names to 1 or 2 characters for simplicity's sake
        frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
        backleft.setDirection(DcMotorSimple.Direction.REVERSE);
        // this part is unnecessary if you use rev core hex motors


        waitForStart();
        while(opModeIsActive()){
            double forward = gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            frontRight.setPower(forward+strafe-turn);
            frontleft.setPower(forward-strafe+turn);
            backRight.setPower(forward-strafe-turn);
            backleft.setPower(forward+strafe+turn);
            /*because mecanum wheels have angled subwheels, they equal distribute velocity between
            forward and sideways directionality. This allows them to move in any direction without
            turning via cancelling out of vectors of force. This is the most common form of code
            used to do this.  */
        }
    }

}
