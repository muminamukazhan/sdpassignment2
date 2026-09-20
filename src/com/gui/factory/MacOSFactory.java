package com.gui.factory;

import com.gui.component.Button;
import com.gui.component.Checkbox;
import com.gui.component.MacOSButton;
import com.gui.component.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}