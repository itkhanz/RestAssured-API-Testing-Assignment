package com.itkhanz.constants;

import com.itkhanz.factories.FakerFactory;

public class Globals {
    //public static final String INVALID_POSTAL_CODE = "22333";
    public static final String INVALID_POSTAL_CODE = FakerFactory.getInstance().getPostCode();

}
