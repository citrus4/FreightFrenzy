package org.firstinspires.ftc.teamcode.commands.drive.atuon;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import com.acmerobotics.roadrunner.trajectory.constraints.MinVelocityConstraint;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Trajectories;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

@Config
public class TwoSplineCommand extends CommandBase{

    Drivetrain drive;
    Trajectory trajectory;
    Vector2d splinePos;
    Vector2d splinePos2;

    boolean reverse = false;
    double endHeading;
    double endHeading2;

    MinVelocityConstraint maxVelConstraint;
    public TwoSplineCommand(Drivetrain drive, MinVelocityConstraint constraint, boolean reverse, Vector2d splinePos, Vector2d splinePos2, double endHeading, double endHeading2) {
        this.drive = drive;
        this.reverse = reverse;
        this.splinePos = splinePos;
        this.splinePos2 = splinePos2;
        this.endHeading = endHeading;
        this.endHeading2 = endHeading2;
        this.maxVelConstraint = constraint;
        this.addRequirements(drive);
    }

    public TwoSplineCommand(Drivetrain drive, Vector2d splinePos, Vector2d splinePos2, double endHeading, double endHeading2) {
        this(drive, Trajectories.velConstraint, false, splinePos, splinePos2, endHeading, endHeading2);
    }

    public TwoSplineCommand(Drivetrain drive, Vector2d splinePos, Vector2d splinePos2, double endHeading, double endHeading2, boolean reverse) {
        this(drive, Trajectories.velConstraint, reverse, splinePos, splinePos2, endHeading, endHeading2);
    }


    @Override
    public void initialize() {
        trajectory = new TrajectoryBuilder(drive.getPoseEstimate(), reverse, maxVelConstraint, Trajectories.accelConstraint).splineTo(splinePos, endHeading).splineTo(splinePos2, endHeading2).build();

        drive.followTrajectory(trajectory);

    }

    @Override
    public void execute() {
        drive.update();
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            drive.stop();
        }
    }

    @Override
    public boolean isFinished() {
        return !drive.isBusy();
    }
}