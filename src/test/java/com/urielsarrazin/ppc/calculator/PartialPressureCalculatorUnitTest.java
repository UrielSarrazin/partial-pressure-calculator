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

package com.urielsarrazin.ppc.calculator;

import com.urielsarrazin.ppc.core.Depth;
import com.urielsarrazin.ppc.core.Gas;
import com.urielsarrazin.ppc.core.Pressure;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

import static com.urielsarrazin.ppc.core.BreathingMix.AIR;
import static com.urielsarrazin.ppc.core.Gas.N2;
import static com.urielsarrazin.ppc.core.Gas.O2;

public class PartialPressureCalculatorUnitTest extends Assert {

    private PartialPressuresCalculResult partialPressuresCalculResult;

    private Map<Gas, Pressure> partialPressuresPerGas;

    @BeforeClass
    void init() {

        partialPressuresCalculResult = new PartialPressuresCalculator(AIR, Depth.create(20))
                .calculatePartialPressures();

        partialPressuresPerGas = partialPressuresCalculResult.getPartialPressuresPerGas();
    }

    @Test
    void breathingMixTest() {
        assertEquals(partialPressuresCalculResult.getBreathingMix(), AIR);
    }

    @Test
    void depthTest() {
        assertTrue(partialPressuresCalculResult.getDepth().getMeters().equals(20));
    }

    @Test
    void partialPressuresPerGasTest() {
        assertEquals(partialPressuresPerGas.size(), 2);
    }

    @Test
    void oxygenPartialPressureTest() {

        assertTrue(partialPressuresPerGas.containsKey(O2));

        final Pressure oxygenPartialPressure = partialPressuresPerGas.get(O2);
        assertEquals(oxygenPartialPressure.getBar(), 0.63D);
    }

    @Test
    void nitrogenPartialPressureTest() {

        assertTrue(partialPressuresPerGas.containsKey(N2));

        final Pressure nitrogenPartialPressure = partialPressuresPerGas.get(N2);
        assertEquals(nitrogenPartialPressure.getBar(), 2.37D);
    }
}