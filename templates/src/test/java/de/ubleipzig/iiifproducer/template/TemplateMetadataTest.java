/*
 * IIIFProducer
 * Copyright (C) 2017 Leipzig University Library <info@ub.uni-leipzig.de>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package de.ubleipzig.iiifproducer.template;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

/**
 * TemplateMetadataTest.
 *
 * @author christopher-johnson
 */
class TemplateMetadataTest {

    @Test
    void testSerialization() {
        final List<TemplateMetadata> meta = new ArrayList<>();
        meta.add(new TemplateMetadata("Kitodo", "12345"));
        meta.add(new TemplateMetadata("URN", "12345"));
        meta.add(new TemplateMetadata("Source PPN (SWB)", "12345"));
        final Optional<String> json = ManifestSerializer.serialize(meta);
        assertTrue(json.isPresent());
        out.println(json.get());
    }

}
