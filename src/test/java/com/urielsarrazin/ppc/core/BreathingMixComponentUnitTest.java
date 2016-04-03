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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BreathingMixComponentUnitTest extends Assert {

    private BreathingMixComponent breathingMixComponent;

    @BeforeClass
    void init() {
        breathingMixComponent = BreathingMixComponent.create(Gas.O2, Pourcentage.create(20D));
    }

    @Test
    void testGas() {
        assertTrue(breathingMixComponent.getGas().equals(Gas.O2));
    }

    @Test
    void testPourcentage() {
        assertTrue(breathingMixComponent.getPourcentage().getValue().equals(20D));
    }
}