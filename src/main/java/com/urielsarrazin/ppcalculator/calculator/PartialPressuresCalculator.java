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

import com.urielsarrazin.ppcalculator.core.*;

import java.util.HashMap;
import java.util.Map;

public class PartialPressuresCalculator {

    private final BreathingMix breathingMix;

    private final Depth depth;

    public PartialPressuresCalculator(BreathingMix breathingMix, Depth depth) {
        this.breathingMix = breathingMix;
        this.depth = depth;
    }

    public PartialPressuresCalculResult calculerPressionsPartielles() {

        final Map<Gas, Pressure> partialPressuresPerGas = new HashMap<>();

        for (BreathingMixComponent breathingMixComponent : breathingMix.getBreathingMixComponents()) {

            final Pressure absolutePressure = Pressure.create(depth);

            final Pourcentage breathingMixComponentPourcentage = breathingMixComponent.getPourcentage();

            final Pressure partialPressure = Pressure.getPartialPressure(absolutePressure, breathingMixComponentPourcentage);

            partialPressuresPerGas.put(breathingMixComponent.getGas(), partialPressure);
        }

        return new PartialPressuresCalculResult(breathingMix, depth, partialPressuresPerGas);
    }
}
