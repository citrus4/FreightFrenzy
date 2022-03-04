package org.firstinspires.ftc.teamcode.autons.regionals.blue.carousel;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.LowerLiftCommand;
import org.firstinspires.ftc.teamcode.commands.LowerLiftNoLimitSwitchCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.SlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.SlowestDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.SplineCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.TurnToCommand;
import org.firstinspires.ftc.teamcode.commands.drive.auton.TwoSplineCommand;
import org.firstinspires.ftc.teamcode.subsystems.Cap;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class BlueRegionalsCarouselRCommand extends SequentialCommandGroup {
    public BlueRegionalsCarouselRCommand(Drivetrain drivetrain, Lift lift, Intake intake, DuckWheels duckWheels, Cap cap, Telemetry telemetry) {
        addCommands(
                new InstantCommand(lift::closeDel),
                //spline around tse to hub
                new TwoSplineCommand(drivetrain, new Vector2d(22,-16), new Vector2d(57,16), 0,260, true),
                //deliver
                new InstantCommand(lift::liftHigh),
                new WaitCommand(500),
                new InstantCommand(lift::openDel),
                new DriveForwardCommand(drivetrain, 6),
                new InstantCommand(lift::closeDel),
                new LowerLiftNoLimitSwitchCommand(lift, cap),
                //spline to carousel
                new TwoSplineCommand(drivetrain, new Vector2d(22,-16), new Vector2d(10,-14), 100,-280, false),
                //turn towards carousel
                new TurnToCommand(drivetrain, 247),
                //drive to carousel
                new SlowDriveForwardCommand(drivetrain, 13),

                new ParallelCommandGroup(
                        new SlowestDriveForwardCommand(drivetrain, 4),
                        new InstantCommand(duckWheels::spinBlueAuton),
                        new WaitCommand(3500)
                          ),
                new InstantCommand(duckWheels::stop),
                new DriveForwardCommand(drivetrain, -10),
                new TurnToCommand(drivetrain, 190),
                new InstantCommand(intake::intake),
                new SlowDriveForwardCommand(drivetrain, 10),
                new DriveForwardCommand(drivetrain, -20)

                //                new IMUTurnCommand(drivetrain, -0)
                //intake duck
                //go back to hub
                //lift high
                //deliver
                //drive forward
                //park
        );
    }
}
