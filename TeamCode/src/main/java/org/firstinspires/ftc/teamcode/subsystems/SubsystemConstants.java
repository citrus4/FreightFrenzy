package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class SubsystemConstants {
    public static int DEGREES_PER_ROTATION = 360;

    public static class Lift {
        public static double DEL_OPEN_POS = 0.485;
        public static double DEL_CLOSE_POS = 0.3;
        public static double DEL_AUTON_POS = 0.31;

        //resting is low
        //public static int RESTING_POSITION = 0;
        public static int LOW_RESTING_POSITION = 75;
        public static int MID_POSITION = 560;
        public static int HIGH_POSITION = 1050;
        //public static int CAP_POSITION = 1000;

        public static double UP_SPEED = 1;
        public static double DOWN_SPEED = -0.2;

        public static double LIFT_TICKS_PER_ROTATION = 384.5; //383.6
        public static PIDFCoefficients LIFT_PID_COEFFICIENTS = new PIDFCoefficients(0.016, 0.00008, 0, 0);
        public static PIDFCoefficients LIFT_PID_COEFFICIENTS_DOWN = new PIDFCoefficients(0.0008, 0.00008, 0, 0);
        public static int LIFT_TOLERANCE = 10;

        public static String LIFT_MOTOR_ID = "lift";
        public static String DELIVERY_MOTOR_ID = "delivery";
    }

    public static class Intake {
        public static double INTAKE_SPEED = 1;
        public static double OUTTAKE_SPEED = -1;

        public static String INTAKE_MOTOR_ID = "intake";
    }
//leo's fired for breaking the robot, 12
    public static class Arm {
        public static double ARM_UP_POS = 0.55;
        public static double ARM_DOWN_POS = 0.05;
        public static double ARM_SCORE_POS = 0.33;
        public static double ARM_REST_POS = 0.4;
        public static String ARM_SERVO_ID = "arm";
        //leo is fired//
    }

    public static class DuckWheels {
        public static double INTAKE_SPEED = 0.5;
        public static double OUTTAKE_SPEED = -0.5;
        public static String RIGHT_393_ID = "right_393";
        public static String LEFT_393_ID = "left_393";
    }
/*

leo is fired, haddon for head builder
 */
    public static class Vision {

    }
}