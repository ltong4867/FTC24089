package org.firstinspires.ftc.teamcode.auto.opmodes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.auto.AutonomousRobot;
import org.firstinspires.ftc.teamcode.auto.paths.Paths;
import org.firstinspires.ftc.teamcode.commands.Commands;
import org.firstinspires.ftc.teamcode.pedroPathing.follower.Follower;
import org.firstinspires.ftc.teamcode.pedroPathing.localization.Pose;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.PathChain;

@Autonomous(name = "4+0", group = "MAIN")
public class FourPlusZero extends CommandOpMode {
    public PathChain chain;
    public Follower follower;
    public AutonomousRobot robot;

    @Override
    public void initialize() {
        this.follower = new Follower(hardwareMap);
        this.robot = new AutonomousRobot(telemetry, hardwareMap, follower);
        this.follower.setStartingPose(new Pose(0, 0, 0));
        this.chain = Paths.fourPlusZero; // This is also a valid path for a simple sample run, just forwards then back

        schedule(
                new RunCommand(robot::update),
                new SequentialCommandGroup(
                        Commands.followPath(follower, chain.getPath(0)).alongWith(
                                Commands.RaiseSlidesForSpecimenDump(robot).andThen(Commands.sleep(800))
                        ),
                        Commands.ClipSpecimen(robot),
                        Commands.fastPath(follower, chain.getPath(1)),
                        Commands.fastPath(follower, chain.getPath(2)),
                        Commands.fastPath(follower, chain.getPath(3)),
                        Commands.fastPath(follower, chain.getPath(4)),
                        Commands.fastPath(follower, chain.getPath(5)),
                        Commands.fastPath(follower, chain.getPath(6)),
                        Commands.fastPath(follower, chain.getPath(7)),
                        Commands.followPath(follower, chain.getPath(8)),
                        Commands.ExtendIntakeToGripSpecimen(robot),
                        Commands.sleep(1000),
                        Commands.GrabGameObjectWithIntake(robot),
                        Commands.RetractIntakeForTransfer(robot),
                        Commands.followPath(follower, chain.getPath(9)).alongWith(
                                Commands.RaiseSlidesForSpecimenDump(robot)
                        ),
                        Commands.ClipSpecimen(robot),
                        Commands.followPath(follower, chain.getPath(10)).alongWith(
                                Commands.ExtendIntakeToGripSpecimen(robot)
                        ),
                        Commands.sleep(1000),
                        Commands.GrabGameObjectWithIntake(robot),
                        Commands.RetractIntakeForTransfer(robot),
                        Commands.followPath(follower, chain.getPath(11)).alongWith(
                                Commands.RaiseSlidesForSampleDump(robot)
                        ),
                        Commands.ClipSpecimen(robot)
                )
        );
    }
}
