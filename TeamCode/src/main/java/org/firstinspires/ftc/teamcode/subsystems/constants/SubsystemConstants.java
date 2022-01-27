package org.firstinspires.ftc.teamcode.subsystems.constants;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@Config
public class SubsystemConstants {
    public static int DEGREES_PER_ROTATION = 360;

    public static class Lift {
        public static double DEL_CLOSE_POS = 0.4;
        public static double DEL_OPEN_POS = 0.6;

        public static int LIFT_RESTING_POSITION = 10;
        public static int LIFT_MID_POSITION = 400;
        public static int LIFT_HIGH_POSITION = 1200;

        public static double LIFT_UP_SPEED = 0.1;
        public static double LIFT_DOWN_SPEED = -0.1;

        public static double LIFT_TICKS_PER_ROTATION = 384.5; //383.6

        public static PIDFCoefficients LIFT_PID_COEFFICIENTS = new PIDFCoefficients(0.0041, 0.00008, 0, 0);

        public static int LIFT_TOLERANCE = 5;

        public static String LIFT_MOTOR_ID = "lift";
        public static String DELIVERY_MOTOR_ID = "delivery";
        public static String DISTANCE_SENSOR_ID = "distance";
    }

    public static class Intake {
        public static double INTAKE_SPEED = 1;
        public static double OUTTAKE_SPEED = -1;

        public static String INTAKE_MOTOR_ID = "intake";
    }

    public static class DuckWheels {
        public static double SPIN_SPEED = 0.45;
        public static double OPPOSITE_SPEED = -0.45;
        public static double AUTON_SPIN_SPEED = 0.3;
        public static double AUTON_OPPOSITE_SPEED = -0.3;
        public static String RIGHT_393_ID = "right_393";
        public static String LEFT_393_ID = "left_393";
    }
/*

leo is fired, haddon for head builder
 */
}