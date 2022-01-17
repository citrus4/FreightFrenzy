package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Util;
import org.firstinspires.ftc.teamcode.drive.SampleTankDrive;

import java.util.List;
import java.util.logging.Level;


public class Drivetrain extends SubsystemBase {

    private final SampleTankDrive drive;
    private Telemetry telemetry;

    double previousForwards = 0;
    double newForward = 0;

    double deccelNum = 0.01;
    double accelNum = 0.07;

    ElapsedTime AccelCheck = new ElapsedTime();

    public Drivetrain(SampleTankDrive drive, Telemetry tl) {
        this.drive = drive;
        this.telemetry = tl;
    }

    public void init() {
        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        drive.setMotorPowers(0, 0);
        drive.setPoseEstimate(new Pose2d());
        AccelCheck.reset();
    }
    @Override
    public void periodic() {
        update();
        Util.logger(this, telemetry, Level.INFO, "current drive: ",getPoseEstimate());
        Util.logger(this, telemetry, Level.INFO, "current drivewheel: ", drive.getWheelPositions());
    }

    public void setMode(DcMotor.RunMode mode) {
        drive.setMode(mode);
    }

    public void setPIDFCoefficients(DcMotor.RunMode mode, PIDFCoefficients coefficients) {
        drive.setPIDFCoefficients(mode, coefficients);
    }

    public void setPoseEstimate(Pose2d pose) {
        drive.setPoseEstimate(pose);
    }

    public void update() {
        drive.update();
    }

    public void tankDrive(double leftY, double rightY) {
        drive.setMotorPowers(leftY, -rightY);
    }

    public void arcadeDrive(double forward, double rotate) {
        double maxInput = Math.copySign(Math.max(Math.abs(forward), Math.abs(rotate)), forward);
        forward = clipRange(forward);
        rotate = clipRange(rotate);
/*
        if(AccelCheck.milliseconds() > 10) {
            Util.logger(this, telemetry, Level.INFO, "Forward: ", forward);
            Util.logger(this, telemetry, Level.INFO, "New forward:", newForward);
            Util.logger(this, telemetry, Level.INFO, "Prev  forward: ", previousForwards);
            AccelCheck.reset();
            if (Math.abs(previousForwards) - Math.abs(forward) < 0) {
                if (previousForwards - forward > deccelNum) {
                    newForward = previousForwards - deccelNum;
                    previousForwards = newForward;
                } else if (previousForwards - forward < -deccelNum) {
                    newForward = previousForwards + deccelNum;
                    previousForwards = newForward;
                } else if ((previousForwards - forward <= deccelNum || previousForwards - forward >= -deccelNum)) {
                    newForward = forward;
                    previousForwards = newForward;
                } else {
                    newForward = 0;
                    previousForwards = 0;
                }
            }
                if (Math.abs(previousForwards) - Math.abs(forward) > 0) {
                    if (previousForwards - forward > accelNum) {
                        newForward = previousForwards - accelNum;
                        previousForwards = newForward;
                    } else if (previousForwards - forward < -accelNum) {
                        newForward = previousForwards + accelNum;
                        previousForwards = newForward;
                    } else if ((previousForwards - forward <= accelNum || previousForwards - forward >= -accelNum)) {
                        newForward = forward;
                        previousForwards = newForward;
                    } else {
                        newForward = 0;
                        previousForwards = 0;
                    }
                } else {
                    newForward = forward;
                    previousForwards = newForward;
                }
        }
 */

        double[] wheelSpeeds = new double[2];
        wheelSpeeds[0] = forward + rotate;
        wheelSpeeds[1] = forward - rotate;

        normalize(wheelSpeeds);

        drive.setMotorPowers(wheelSpeeds[0], wheelSpeeds[1]);
    }

    public void setDrivePower(Pose2d drivePower) {
        drive.setDrivePower(drivePower);
    }

    public void setWeightedDrivePower(Pose2d drivePower) {
        drive.setWeightedDrivePower(drivePower);
    }

    public Pose2d getPoseEstimate() {
        return drive.getPoseEstimate();
    }
    public double getHeading() {
        return Math.toDegrees(drive.getExternalHeading());
    }
    public double getRawHeading() {
        return Math.toDegrees(drive.getRawExternalHeading());
    }

    public TrajectoryBuilder trajectoryBuilder(Pose2d startPose) {
        return drive.trajectoryBuilder(startPose);
    }

    public TrajectoryBuilder trajectoryBuilder(Pose2d startPose, boolean reversed) {
        return drive.trajectoryBuilder(startPose, reversed);
    }

    public TrajectoryBuilder trajectoryBuilder(Pose2d startPose, double startHeading) {
        return drive.trajectoryBuilder(startPose, startHeading);
    }

    public void followTrajectory(Trajectory trajectory) {
        drive.followTrajectoryAsync(trajectory);
    }

    public void followTrajectoryBlock(Trajectory trajectory) {
        drive.followTrajectory(trajectory);
    }

    public boolean isBusy() {
        return drive.isBusy();
    }

    public void turn(double radians) {
        drive.turnAsync(radians);
    }

    public void turnTo(double radians) {
        drive.turnToAsync(radians);
    }

    public void turnBlock(double radians) {
        drive.turn(radians);
    }

    public List<Double> getWheelVelocities() {
        return drive.getWheelVelocities();
    }

    public void stop() {
        tankDrive(0, 0);
    }

    public Pose2d getPoseVelocity() {
        return drive.getPoseVelocity();
    }

    private double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }

    /**
     * Returns minimum range value if the given value is less than
     * the set minimum. If the value is greater than the set maximum,
     * then the method returns the maximum value.
     *
     * @param value The value to clip.
     */
    public double clipRange(double value) {
        return value <= -1 ? -1
                : value >= 1 ? 1
                : value;
    }

    /**
     * Normalize the wheel speeds
     */
    protected void normalize(double[] wheelSpeeds, double magnitude) {
        double maxMagnitude = Math.abs(wheelSpeeds[0]);
        for (int i = 1; i < wheelSpeeds.length; i++) {
            double temp = Math.abs(wheelSpeeds[i]);
            if (maxMagnitude < temp) {
                maxMagnitude = temp;
            }
        }
        for (int i = 0; i < wheelSpeeds.length; i++) {
            wheelSpeeds[i] = (wheelSpeeds[i] / maxMagnitude) * magnitude;
        }

    }

    /**
     * Normalize the wheel speeds
     */
    protected void normalize(double[] wheelSpeeds) {
        double maxMagnitude = Math.abs(wheelSpeeds[0]);
        for (int i = 1; i < wheelSpeeds.length; i++) {
            double temp = Math.abs(wheelSpeeds[i]);
            if (maxMagnitude < temp) {
                maxMagnitude = temp;
            }
        }
        if(maxMagnitude > 1) {
            for (int i = 0; i < wheelSpeeds.length; i++) {
                wheelSpeeds[i] = (wheelSpeeds[i] / maxMagnitude);
            }
        }

    }
}