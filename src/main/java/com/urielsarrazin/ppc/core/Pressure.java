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

public class Pressure {

    private final static Double ATHMOSPERIC_PRESSURE = 1D;

    private final Double bar;

    private Pressure(Double bar) {
        this.bar = bar;
    }

    public static Pressure createWithBars(Double pressure) {
        return new Pressure(pressure);
    }

    public static Pressure createWithDepthInMeters(Depth depth) {
        return Pressure.createWithBars(ATHMOSPERIC_PRESSURE + (double) depth.getMeters() / 10);
    }

    public static Pressure getPartialPressure(Pressure absolutePressure, Pourcentage pourcentage) {
        return Pressure.createWithBars(absolutePressure.getBar() * pourcentage.getValue() / 100);
    }

    public Double getBar() {
        return bar;
    }
}
