package com.app;

import com.gui.factory.GUIFactory;
import com.gui.factory.MacOSFactory;
import com.gui.factory.WindowsFactory;

public final class GUIFactorySelector {

    private GUIFactorySelector() {
    }

    public static GUIFactory select(UIPlatform platform) {
        return switch (platform) {
            case WINDOWS -> new WindowsFactory();
            case MACOS -> new MacOSFactory();
        };
    }
}