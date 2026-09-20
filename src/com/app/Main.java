package com.app;

import com.gui.factory.GUIFactory;
import com.logistics.creator.Logistics;

import java.util.Scanner;

public class Main {

    private static final String SAMPLE_CARGO = "laboratory equipment";
    private static final String SAMPLE_DESTINATION = "Aktau warehouse";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String modeArgument = args.length > 0 ? args[0] : null;
        String platformArgument = args.length > 1 ? args[1] : null;

        DeliveryMode mode = InputReader.readDeliveryMode(scanner, modeArgument);
        if (mode == null) {
            return;
        }

        UIPlatform platform = InputReader.readUIPlatform(scanner, platformArgument);
        if (platform == null) {
            return;
        }

        Logistics logistics = LogisticsSelector.select(mode);
        GUIFactory guiFactory = GUIFactorySelector.select(platform);

        System.out.println("Delivery mode: " + mode);
        System.out.println("UI platform: " + platform);

        DeliveryApplication application = new DeliveryApplication(guiFactory, logistics);
        application.run(SAMPLE_CARGO, SAMPLE_DESTINATION);
    }
}