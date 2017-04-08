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

import org.junit.Assert;
import org.junit.Test;

public class BannerUnitTest extends Assert {

    private static final Banner banner = new Banner();

    @Test
    public void getBannerTest() {

        final String expectedBanner = new StringBuilder()
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

        assertEquals(banner.getBanner(), expectedBanner);
    }

    @Test
    public void getProviderNameTest() {
        assertEquals(banner.getProviderName(), "Partial Pressure Calculator");
    }

    @Test
    public void getWelcomeMessageTest() {
        assertEquals(banner.getWelcomeMessage(), "Welcome to the Partial Pressure Calculator.");
    }
}