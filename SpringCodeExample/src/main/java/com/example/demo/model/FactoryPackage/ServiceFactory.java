package com.example.demo.model.FactoryPackage;

import com.example.demo.model.DisplayPackage.Display;
import com.example.demo.model.SevicePackage.service;

public abstract class ServiceFactory {
    Display display;
    public abstract service chooseService(int option);
}
