package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@Disabled
@TeleOp(name="DriveMotorTest")
public class TestMotors extends OpMode {
    //hardware initialization stuff
    Servo servo;
    double pos = 0;
    // add/remove motors depending on your robot (e.g., 6WD)
    DcMotorEx leftFront;
    DcMotorEx leftCenter;
    DcMotorEx leftRear;
    DcMotorEx rightRear;
    DcMotorEx rightCenter;
    DcMotorEx rightFront;
    /**
     * User defined init method
     * <p>
     * This method will be called once when the INIT button is pressed.
     */
    @Override
    public void init() {
        leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        leftCenter = hardwareMap.get(DcMotorEx.class, "leftCenter");
        leftRear = hardwareMap.get(DcMotorEx.class, "leftRear");
        rightRear = hardwareMap.get(DcMotorEx.class, "rightRear");
        rightCenter = hardwareMap.get(DcMotorEx.class, "rightCenter");
        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");

        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        leftCenter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightCenter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        servo = hardwareMap.get(Servo.class, "delivery");
    }

    /**
     * User defined loop method
     * <p>
     * This method will be called repeatedly in a loop while this op mode is running
     */
    @Override
    public void loop() {
        leftFront.setPower(0.5);
        telemetry.addData("current pos", leftFront.getCurrentPosition());
        telemetry.update();
    }
}