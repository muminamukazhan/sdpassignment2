package com.gui.factory;

import com.gui.component.Button;
import com.gui.component.Checkbox;
import com.gui.component.WindowsButton;
import com.gui.component.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}