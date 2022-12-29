package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import com.qualcomm.robotcore.hardware.HardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import java.util.Random;
import org.firstinspires.ftc.robotcore.external.navigation.Rotation;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.*;
import android.graphics.Color;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import java.lang.annotation.Target;
import com.qualcomm.robotcore.*;
import java.util.*;
import java.io.*;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.DigitalChannelController;
import com.qualcomm.robotcore.hardware.DigitalChannel;



@Autonomous(name="Meet2BlueCorners",group="Linear Opmode") 

public class Meet2BlueCorners extends DarienOpMode{

public void runOpMode() {
            
        initialize();
        
        // Wait for the driver to start - must press play -- will run until driver presses 
        waitForStart(); // WAITS UNTIL START BUTTON IS PRESSED
        grabServo.setPower(0.05); //closes the grab servo as a safety measure
        MoveZ(-5400, armPower); // moves the arm up
        //Moves center of the robot to the center of the first tile
        MoveY(robotCenterAtStart + 2*tileDist + 2*tileDist/5 - 20, autoPower); 
        //8750 is the ratio for how long you have to wait to detect color on any given power
        sleep((long) Math.floor((8750 * autoPower) + 0.5));
        parkPos = getParkPos(); //reads signal cone
        grabServo.setPower(0); // stop squeezing the claw
        waitForMotors();
        MoveY(-2*tileDist/5 + 90, autoPower); //backs up to center of high pole tile
        waitForMotors();
        
        //Start loop to stack cones on high
        for (int i=0; i<conesMax; i++) {
            dropBlueCone();
            
            Rotate(265); //turn towards stack
            waitForMotors();
            MoveZ(-570 + (i*165), armPower); //lower arm
            moveToConeStack();
        //finished grabbing cone. Placing on high pole
        }
        dropBlueCone();
        //parks
        Rotate(270);
        while(omniMotor0.isBusy()){}
        
        switch(parkPos)
        {
            //Green
            case 1:
                MoveY(-615, 0.25);
                break;
            //Red
            case 2:
                MoveY(0, 0.25);
                break;
            //Blue
            case 3:
                MoveY(615, 0.25);
                break;
        }
        while (omniMotor0.isBusy()){}
        // Rotate(225);
        // MoveY(-320, autoPower);
        // MoveZ(-3000, armPower);
        // waitForMotors();
        // while(linearExtender.isBusy()){}
        // grabServo.setPower(-0.35);
        // sleep(300);
        // grabServo.setPower(0);
        
        // sleep(100);
        // //move to color cone
        // MoveY(tileDist, autoPower);
        // while (omniMotor0.isBusy()){}
        // // sleep(200);
        // sleep(100);
        // parkPos = getParkPos();
        // MoveY(tileDist, autoPower);
        // while(omniMotor0.isBusy()){}
        // // sleep(200);
        // sleep(100);
        // while (omniMotor0.isBusy()){}
        // MoveY(tileDist/2 , autoPower);
        // while(omniMotor0.isBusy()){}
        // sleep(100);
        // MoveY(-tileDist/2 , autoPower);
        // sleep(100);
        // while(omniMotor0.isBusy()){}
        // // MoveY(250,autoPower);
        // // sleep(100);
        // // while(omniMotor0.isBusy()){}
        // // Rotate(270);
        // // while(omniMotor0.isBusy()){}
        
        // Rotate(225);
        // while(omniMotor0.isBusy()){}
        // sleep(100);
        // MoveY(-310,autoPower);
        // while(omniMotor0.isBusy()){}
        // sleep(100);
        // MoveY(10, autoPower);
        // while(omniMotor0.isBusy()){}
        // MoveZ(-3200, 0.3);
        // while(linearExtender.isBusy()){}
        // MoveY(300,autoPower);
        // sleep(100);
        // while(omniMotor0.isBusy()){}
    //     stop, add color sensing code
    //   get parking space
       
 

    //     RotateOld(500, 0.5);
    //     while (omniMotor0.isBusy()){}
    //     //back up to pole
    //     MoveY(-175, 0.125);
    //     while (omniMotor0.isBusy()){}
    //     MoveY(-100, 0.11);
    //     while (omniMotor0.isBusy()){}
    //     // MoveY(5, 0.1);
    //     // while (omniMotor0.isBusy()){}
    //     sleep(100);
    //     //drop cone
    //     grabServo.setPower(0.5);
    //     sleep(100);
    //     //return
    //     grabServo.setPower(-0.1);
    //     MoveY(275, 0.125);
    //     while (omniMotor0.isBusy()){}
    //     RotateOld(475, 0.5);
        
    //     while (omniMotor0.isBusy()){}
    //     //GotoParking Space
    //     switch(parkPos)
    //     {
    //         //Green
    //         case 1:
    //             MoveY(-600, 0.25);
    //             break;
    //         //Red
    //         case 2:
    //             MoveY(0, 0.25);
    //             break;
    //         //Blue
    //         case 3:
    //             RotateOld(-25, 0.3);
    //             while (omniMotor0.isBusy()){}
    //             MoveY(625, 0.25);
    //             break;
    //     }
    //   while (omniMotor0.isBusy()){}
    //     // Rotate(950, 0.33);
    //     // while (omniMotor0.isBusy()){}
    //     // MoveY(-300, 0.15);
    //     wristServo.setPower(-1);
    //     sleep(500);
        // MoveZ(0, 0.125);
    //      MoveY(800,  0.125);
 while (opModeIsActive()){        
    
    this.telemetry.addData("TargetPos", Integer.toString(ZencoderPos));
    this.telemetry.addData("encoder", Integer.toString(linearExtender.getCurrentPosition()));
    this.telemetry.addData("alpha", Integer.toString(colorSensor0.alpha()));
    this.telemetry.addData("blue: ", Integer.toString(colorSensor0.blue()));
    this.telemetry.addData("green: ", Integer.toString(colorSensor0.green()));
    this.telemetry.addData("red: ", Integer.toString(colorSensor0.red()));
    this.telemetry.addData("hue: ", Integer.toString(colorSensor0.argb()));
    this.telemetry.addData("Rotation: ", Double.toString(getRawHeading()));
    this.telemetry.update();
 
    }   
}
    private void dropBlueCone() {
        //starts at the center of the high pole tile drops the cone on that pole.
        Rotate(225); //turn towards high pole
        waitForMotors();
        MoveY(-320, autoPower); //push towards pole
        waitForMotors();
        MoveZ(-3000, armPower); //lower linear extender
        while(linearExtender.isBusy()){}
        grabServo.setPower(-0.55); //open claw to drop cone
        sleep(50);
        Rotate(225); //re-allign robot
        waitForMotors();
        MoveY(255, autoPower); //back up to center of tile
        sleep(125);
        grabServo.setPower(0); //stop opening claw
        waitForMotors();
    }

}
