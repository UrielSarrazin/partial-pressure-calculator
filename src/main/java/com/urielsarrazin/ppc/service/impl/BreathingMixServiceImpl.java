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

package com.urielsarrazin.ppc.service.impl;

import com.urielsarrazin.ppc.calculator.PartialPressuresCalculResult;
import com.urielsarrazin.ppc.calculator.PartialPressuresCalculator;
import com.urielsarrazin.ppc.core.BreathingMix;
import com.urielsarrazin.ppc.core.Depth;
import com.urielsarrazin.ppc.service.BreathingMixService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BreathingMixServiceImpl implements BreathingMixService {

    @Override
    public List<PartialPressuresCalculResult> calculatePartialPressures(BreathingMix breathingMix) {

        final List<PartialPressuresCalculResult> partialPressuresCalculResults = new ArrayList<>();

        for (int depth = 0; depth <= 60; depth++) {

            final Depth currentDepth = Depth.create(depth);

            final PartialPressuresCalculator partialPressuresCalculator = new PartialPressuresCalculator(breathingMix, currentDepth);

            final PartialPressuresCalculResult partialPressuresCalculResult = partialPressuresCalculator.calculatePartialPressures();

            partialPressuresCalculResults.add(partialPressuresCalculResult);
        }

        return partialPressuresCalculResults;
    }
}
