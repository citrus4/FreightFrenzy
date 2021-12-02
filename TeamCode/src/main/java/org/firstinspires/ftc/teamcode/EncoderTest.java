package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@Disabled
@TeleOp(name="Encoder Test")
public class EncoderTest extends OpMode {
    //hardware initialization stuff
    DcMotorEx testMotor;

    /**
     * User defined init method
     * <p>
     * This method will be called once when the INIT button is pressed.
     */
    @Override
    public void init() {
        testMotor = hardwareMap.get(DcMotorEx.class, "testMotor");
    }

    /**
     * User defined loop method
     * <p>
     * This method will be called repeatedly in a loop while this op mode is running
     */
    @Override
    public void loop() {

        telemetry.addData("pos",testMotor.getCurrentPosition());
        //telemetry.addData("desired pos", pos);
        telemetry.update();

    }
}