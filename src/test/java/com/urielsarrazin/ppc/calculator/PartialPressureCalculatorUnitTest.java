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
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static com.urielsarrazin.ppc.core.BreathingMix.AIR;
import static com.urielsarrazin.ppc.core.Gas.N2;
import static com.urielsarrazin.ppc.core.Gas.O2;

public class PartialPressureCalculatorUnitTest extends Assert {

    private static PartialPressuresCalculResult partialPressuresCalculResult;

    private static Map<Gas, Pressure> partialPressuresPerGas;

    @BeforeClass
    public static void init() {

        partialPressuresCalculResult = new PartialPressuresCalculator(AIR, Depth.create(20))
                .calculatePartialPressures();

        partialPressuresPerGas = partialPressuresCalculResult.getPartialPressuresPerGas();
    }

    @Test
    public void breathingMixTest() {
        assertEquals(partialPressuresCalculResult.getBreathingMix(), AIR);
    }

    @Test
    public void depthTest() {
        assertTrue(partialPressuresCalculResult.getDepth().getMeters().equals(20));
    }

    @Test
    public void partialPressuresPerGasTest() {
        assertEquals(partialPressuresPerGas.size(), 2);
    }

    @Test
    public void oxygenPartialPressureTest() {

        assertTrue(partialPressuresPerGas.containsKey(O2));

        final Pressure oxygenPartialPressure = partialPressuresPerGas.get(O2);
        assertEquals(oxygenPartialPressure.getBar(), new Double(0.63));
    }

    @Test
    public void nitrogenPartialPressureTest() {

        assertTrue(partialPressuresPerGas.containsKey(N2));

        final Pressure nitrogenPartialPressure = partialPressuresPerGas.get(N2);
        assertEquals(nitrogenPartialPressure.getBar(), new Double(2.37));
    }
}