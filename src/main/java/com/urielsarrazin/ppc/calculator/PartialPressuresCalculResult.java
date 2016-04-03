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

import com.urielsarrazin.ppc.core.BreathingMix;
import com.urielsarrazin.ppc.core.Depth;
import com.urielsarrazin.ppc.core.Gas;
import com.urielsarrazin.ppc.core.Pressure;

import java.util.Map;

public class PartialPressuresCalculResult {

    private final BreathingMix breathingMix;

    private final Depth depth;

    private final Map<Gas, Pressure> partialPressuresPerGas;

    public PartialPressuresCalculResult(BreathingMix breathingMix, Depth depth, Map<Gas, Pressure> partialPressuresPerGas) {
        this.breathingMix = breathingMix;
        this.depth = depth;
        this.partialPressuresPerGas = partialPressuresPerGas;
    }

    public BreathingMix getBreathingMix() {
        return breathingMix;
    }

    public Depth getDepth() {
        return depth;
    }

    public Map<Gas, Pressure> getPartialPressuresPerGas() {
        return partialPressuresPerGas;
    }
}
