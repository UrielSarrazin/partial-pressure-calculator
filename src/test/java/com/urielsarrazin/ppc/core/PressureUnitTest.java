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

package com.urielsarrazin.ppc.core;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PressureUnitTest extends Assert {

    @Test
    void creationWithPressureTest() {

        final Pressure pressure = Pressure.create(1D);

        assertEquals(pressure.getBar(), 1.0D);
    }

    @Test
    void creationWithDepthTest() {

        final Pressure pressure = Pressure.create(Depth.create(12));

        assertEquals(pressure.getBar(), 2.2D);
    }

    @Test
    void getPartialPressureTest() {

        final Pressure partialPressure = Pressure.getPartialPressure(Pressure.create(1D), Pourcentage.create(20D));

        assertEquals(partialPressure.getBar(), 0.2D);
    }
}