package org.firstinspires.ftc.teamcode.tele;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

@Disabled
@TeleOp

public class Teleop extends LinearOpMode{
    DcMotorEx m1,m2,m3,m4,rotator
//    TouchSensor ButtonOne, ButtonTwo;
    public void runOpMode() {
        m1 = (DcMotorEx) hardwareMap.dcMotor.get("front_left_motor");
        m2 = (DcMotorEx) hardwareMap.dcMotor.get("back_left_motor");
        m3 = (DcMotorEx) hardwareMap.dcMotor.get("front_right_motor");
        m4 = (DcMotorEx) hardwareMap.dcMotor.get("back_right_motor");

        m1.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        m2.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        m3.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        m4.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);


        // Idk what motors you need to reverse, so
        m1.setDirection(DcMotorSimple.Direction.REVERSE);
        m2.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();


        while (opModeIsActive()) {
            double px = gamepad1.left_stick_x;
            double py = -gamepad1.left_stick_y;
            double pa = -gamepad1.right_stick_x;

            double p1 = px + py - pa;
            double p2 = -px + py - pa;
            double p3 = -px + py + pa;
            double p4 = px + py + pa;
            double max = Math.max(1.0, Math.abs(p1));
            max = Math.max(max, Math.abs(p2));
            max = Math.max(max, Math.abs(p3));
            max = Math.max(max, Math.abs(p4));
            p1 /= max;
            p2 /= max;
            p3 /= max;
            p4 /= max;
            m1.setPower(p1);
            m2.setPower(p2);
            m3.setPower(p3);
            m4.setPower(p4);
        }
    }
}