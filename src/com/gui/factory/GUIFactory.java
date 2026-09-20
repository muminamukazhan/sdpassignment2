package com.gui.factory;

import com.gui.component.Button;
import com.gui.component.Checkbox;

public interface GUIFactory {

    Button createButton();

    Checkbox createCheckbox();
}