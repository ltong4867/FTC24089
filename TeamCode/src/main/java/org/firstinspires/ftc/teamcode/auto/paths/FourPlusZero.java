package org.firstinspires.ftc.teamcode.auto.paths;

import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.BezierLine;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.PathBuilder;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.PathChain;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.Point;

public class FourPlusZero {
    public static PathChain path() {
        PathBuilder builder = new PathBuilder();
        builder
                .addPath(
                        // Line 1
                        new BezierLine(
                                new Point(0.0, 0.0, Point.CARTESIAN),
                                new Point(-25.6, 0.0, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(0)
                .addPath(
                        // Line 1
                        new BezierLine(
                                new Point(-25.6, 0.0, Point.CARTESIAN),
                                new Point(-25.6, 25.6, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(0)
                .addPath(
                        new BezierLine(
                                new Point(-25.6, 25.6, Point.CARTESIAN),
                                new Point(-48.4, 25.6, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(0)
                .addPath(
                        new BezierLine(
                                new Point(-48.4, 25.6, Point.CARTESIAN),
                                new Point(-48.4, 37.4, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(0)
                .addPath(
                        new BezierLine(
                                new Point(-48.4, 37.4, Point.CARTESIAN),
                                new Point(-3, 37.4, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(0)
                .addPath(
                        new BezierLine(
                                new Point(-3, 37.4, Point.CARTESIAN),
                                new Point(-48.4, 37.4, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(0)
                .addPath(
                        new BezierLine(
                                new Point(-48.4, 37.4, Point.CARTESIAN),
                                new Point(-48.4, 47.4, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(0)
                .addPath(
                        new BezierLine(
                                new Point(-48.4, 47.4, Point.CARTESIAN),
                                new Point(-3, 47.4, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(0)
                .addPath(
                    new BezierLine(
                            new Point(-3, 47.4, Point.CARTESIAN),
                            new Point(-18, 23, Point.CARTESIAN)
                    )
                )
                .setConstantHeadingInterpolation(Math.toRadians(45))
                .addPath(
                    new BezierLine(
                            new Point(-18, 23, Point.CARTESIAN),
                            new Point(-25.6, 5.0, Point.CARTESIAN)
                    )
                )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .addPath( new BezierLine(
                        new Point(-25.6, 5, Point.CARTESIAN),
                        new Point(-18, 23.0, Point.CARTESIAN)
                )
        )
                .setConstantHeadingInterpolation(Math.toRadians(45))
                .addPath( new BezierLine(
                        new Point(-18, 23.0, Point.CARTESIAN),
                        new Point(-25.6, -5, Point.CARTESIAN)
                )
        )
                .setConstantHeadingInterpolation(Math.toRadians(0));
        return builder.build();
    }
}