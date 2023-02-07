package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/// Here is the imports and packages of a program. This is automated in Android studio.

@TeleOp
public class Tutorial extends LinearOpMode {
    DcMotor rightMotor;
    DcMotor leftMotor;

    ColorSensor colorSensor;

    Servo hand;

    double numbers = 9000;

/*    This is where you declare the things that you're going to use in the code, as well as the
names these things are going to be called by throughout the program. The format is the object type
(Dcmotor, servo, etc.) followed by its name. */
    @Override
    public void runOpMode(){

        rightMotor = hardwareMap.dcMotor.get("rm");
        leftMotor = hardwareMap.dcMotor.get("lm");

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
/* This particular line of code makes all numeric information for this object into its opposite
for example, if this motor's power was set to 1, it would actually be set to -1. This is useful
since all motors have positive as counter-clockwise, and you'll often have motors facing opposite
directions.  */

        colorSensor = hardwareMap.colorSensor.get("cs");
        hand = hardwareMap.servo.get("h");

        /* This is where you declare the names that an object will go by in configuration.
        For more information about configuration, check out HOW-TOs and TUTORIALS in the team
        google drive.*/

        hand.setPosition(1);  ///You can also have things happen on INIT here.
        ///things that move on INIT must have a sticker on them saying such.

        waitForStart();
        while(opModeIsActive()){
            //these two commands do precisely what they sound like.
            rightMotor.setPower(gamepad1.right_stick_y);
            leftMotor.setPower(gamepad1.left_stick_y);
            /* Controllers have two variables in their analog sticks: x(left to right) and y(down
            to up) which are stored as doubles (having up to one decimal place) from -1 as far left
            or down and 1 as far right or up. This can be mapped to the -1 to 1 of motors very
            easily. */
            if (gamepad1.x) {
                hand.setPosition(1);
            }
            if (gamepad1.a){
                hand.setPosition(0);
            }
            /*if statements are boolean functions - meaning they are either true or false, which
            maps well to controller buttons which are boolean inputs. Servos, similarly to
            motors, are measured from -1 to 1 but instead of being power that is measured, it's
            position. Most of the time servos have 270 degrees of motion but this isn't a sure
            thing. */
        }
    }
}
