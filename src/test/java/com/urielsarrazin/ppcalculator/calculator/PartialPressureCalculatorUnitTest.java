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

package com.urielsarrazin.ppcalculator.calculator;

import com.urielsarrazin.ppcalculator.core.BreathingMix;
import com.urielsarrazin.ppcalculator.core.Depth;
import com.urielsarrazin.ppcalculator.core.Gas;
import com.urielsarrazin.ppcalculator.core.Pressure;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class PartialPressureCalculatorUnitTest extends Assert {

    @Test
    void testCalculatePartialPressure() {

        final PartialPressuresCalculResult partialPressuresCalculResult = new PartialPressuresCalculator(BreathingMix.AIR, Depth.create(20))
                .calculatePartialPressures();

        assertTrue(partialPressuresCalculResult.getBreathingMix().equals(BreathingMix.AIR));

        assertTrue(partialPressuresCalculResult.getDepth().getMeters().equals(20));

        final Map<Gas, Pressure> partialPressuresPerGas = partialPressuresCalculResult.getPartialPressuresPerGas();

        assertTrue(partialPressuresPerGas.size() == 2);

        assertTrue(partialPressuresPerGas.containsKey(Gas.O2));
        assertTrue(partialPressuresPerGas.get(Gas.O2).getBar().equals(0.63D));

        assertTrue(partialPressuresPerGas.containsKey(Gas.N2));
        assertTrue(partialPressuresPerGas.get(Gas.N2).getBar().equals(2.37D));
    }
}