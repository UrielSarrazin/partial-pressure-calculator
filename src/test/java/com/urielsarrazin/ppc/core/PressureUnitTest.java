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

import org.junit.Assert;
import org.junit.Test;

public class PressureUnitTest extends Assert {

    @Test
    public void creationWithPressureTest() {

        final Pressure pressure = Pressure.createWithBars(1D);

        assertEquals(pressure.getBar(), new Double(1));
    }

    @Test
    public void creationWithDepthTest() {

        final Pressure pressure = Pressure.createWithDepthInMeters(Depth.create(12));

        assertEquals(pressure.getBar(), new Double(2.2));
    }

    @Test
    public void getPartialPressureTest() {

        final Pressure partialPressure = Pressure.getPartialPressure(Pressure.createWithBars(1D), Pourcentage.create(20D));

        assertEquals(partialPressure.getBar(), new Double(0.2));
    }
}