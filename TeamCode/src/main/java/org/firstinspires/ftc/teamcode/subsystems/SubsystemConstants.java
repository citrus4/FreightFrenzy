package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class SubsystemConstants {
    public static int DEGREES_PER_ROTATION = 360;

    public static class Lift {
        public static double DEL_OPEN_POS = 0.477;
        public static double DEL_CLOSE_POS = 0.038;

        public static int RESTING_POSITION = 100;
        public static int LOW_POSITION = 400;
        public static int MID_POSITION = 600;
        public static int HIGH_POSITION = 800;
        public static int CAP_POSITION = 1000;

        public static double UP_SPEED = 1;
        public static double DOWN_SPEED = -1;

        public static double LIFT_TICKS_PER_ROTATION = 384.5; //383.6
        public static PIDFCoefficients LIFT_PID_COEFFICIENTS = new PIDFCoefficients(0.005, 0.00008, 0, 0); //(0.005, 0.0001, 0.003, 0);
        public static int LIFT_TOLERANCE = 10;


        public static String LIFT_MOTOR_ID = "lift";
        public static String DELIVERY_MOTOR_ID = "delivery";
    }

    public static class Intake {
        public static double INTAKE_SPEED = 1;
        public static double OUTTAKE_SPEED = -1;

        public static String INTAKE_MOTOR_ID = "intake";
    }

    public static class Vision {

    }
}