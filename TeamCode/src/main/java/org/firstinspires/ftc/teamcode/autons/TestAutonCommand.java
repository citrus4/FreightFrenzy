package org.firstinspires.ftc.teamcode.autons;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.checkerframework.common.reflection.qual.NewInstance;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.autons.champs.blue.CarouselBlueCommandSequence;
import org.firstinspires.ftc.teamcode.commands.drive.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.FastDriveCommand;
import org.firstinspires.ftc.teamcode.commands.drive.IMUTurnCommand;
import org.firstinspires.ftc.teamcode.commands.drive.KindaSlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.ReallySlowDriveCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SlowestDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.drive.SplineCommand;
import org.firstinspires.ftc.teamcode.commands.drive.TurnCommand;
import org.firstinspires.ftc.teamcode.commands.drive.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.DuckWheels;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Lift;

public class TestAutonCommand extends SequentialCommandGroup {
    public TestAutonCommand(Drivetrain drivetrain, Intake intake, DuckWheels duckWheels, Lift lift, Telemetry telemetry) {
        //declare variables here

        addCommands(
                //testing blue left carasouel
                //command sequence
                //duck
                new CarouselBlueCommandSequence(drivetrain, lift, duckWheels, telemetry),


                //--------------------end command sequence------------------------------------------
                //--------------------------finished------------------------------------------------

                //deliver pre-load
                //left(low)
                new SplineCommand(drivetrain, new Vector2d(25, 5.4), -230, true),
                new WaitCommand(200),

                //new IMUTurnCommand(drivetrain, 135, true),
                new IMUTurnCommand(drivetrain, -230, true),
                new InstantCommand(lift::liftLow),

                new SlowDriveForwardCommand(drivetrain, -2),
                new WaitCommand(200),

                new InstantCommand(lift::toggleDel),
                new SlowDriveForwardCommand(drivetrain, 8),
                new InstantCommand(lift::toggleDel),

                //park
                new TurnToCommand(drivetrain, 270, true),
                new SplineCommand(drivetrain,new Vector2d( 10, -10), 270, true)

        );
    }
}