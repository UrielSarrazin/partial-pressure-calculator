/*
 * Copyright (C) 2016 Uriel Sarrazin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.urielsarrazin.ppc;

import org.springframework.shell.Bootstrap;
import org.springframework.shell.core.CommandResult;
import org.springframework.shell.core.JLineShellComponent;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BannerUnitTest extends Assert {

    private static final Banner banner = new Banner();

    @Test
    public void getBannerTest() {

        final String expecteBanner = new StringBuilder()
                .append("        ######   #####                                                                \n")
                .append(" #####  #     # #     #   ##   #       ####  #    # #        ##   #####  ####  #####  \n")
                .append(" #    # #     # #        #  #  #      #    # #    # #       #  #    #   #    # #    # \n")
                .append(" #    # ######  #       #    # #      #      #    # #      #    #   #   #    # #    # \n")
                .append(" #####  #       #       ###### #      #      #    # #      ######   #   #    # #####  \n")
                .append(" #      #       #     # #    # #      #    # #    # #      #    #   #   #    # #   #  \n")
                .append(" #      #        #####  #    # ######  ####   ####  ###### #    #   #    ####  #    # \n")
                .append("                                                                                      \n")
                .append("                                                                                      \n")
                .append("                                                                                      \n")
                .toString();

        assertEquals(banner.getBanner(), expecteBanner);
    }

    @Test
    public void getProviderNameTest() {

        final String expecteProviderName = "Partial Pressure Calculator";

        assertEquals(banner.getProviderName(), expecteProviderName);
    }

    @Test
    public void getWelcomeMessageTest() {

        final String expecteWelcomeMessage = "Welcome to the Partial Pressure Calculator.";

        assertEquals(banner.getWelcomeMessage(), expecteWelcomeMessage);
    }
}