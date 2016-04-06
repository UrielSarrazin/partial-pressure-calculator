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

package com.urielsarrazin.ppc.service;

import com.urielsarrazin.ppc.calculator.PartialPressuresCalculResult;
import com.urielsarrazin.ppc.core.BreathingMix;
import com.urielsarrazin.ppc.service.impl.BreathingMixServiceImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BreathingMixServiceUnitTest extends Assert {

    @Test
    void partialPressuresCalculationTest() {

        final List<PartialPressuresCalculResult> partialPressuresCalculResults = new BreathingMixServiceImpl()
                .calculatePartialPressures(BreathingMix.AIR);

        assertEquals(partialPressuresCalculResults.size(), 61);
    }
}