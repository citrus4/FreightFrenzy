package org.firstinspires.ftc.teamcode.commands.drive.teleOp;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import com.acmerobotics.roadrunner.trajectory.constraints.MinVelocityConstraint;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Trajectories;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

@Config
public class FastDriveCommand extends CommandBase{

    Drivetrain drive;
    double distance;
    Trajectory trajectory;
    MinVelocityConstraint constraint;

    public FastDriveCommand(Drivetrain drive, double distance) {
        this.drive = drive;
        this.distance = distance;
        constraint = Trajectories.fastVelConstraint;
        this.addRequirements(drive);
    }

    public FastDriveCommand(Drivetrain drive, double distance, MinVelocityConstraint constraint) {
        this.drive = drive;
        this.distance = distance;
        this.constraint = constraint;
        this.addRequirements(drive);
    }

    @Override
    public void initialize() {
        if (distance > 0)
            trajectory = new TrajectoryBuilder(drive.getPoseEstimate(), constraint, Trajectories.accelConstraint).forward(distance).build();
        else
            trajectory = new TrajectoryBuilder(drive.getPoseEstimate(), constraint, Trajectories.accelConstraint).back(-distance).build();

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