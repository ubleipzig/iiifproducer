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

package org.ubl.iiifproducer.doc;

import static org.apache.log4j.Logger.getLogger;
import static org.ubl.iiifproducer.doc.MetsManifestBuilder.getMetsFromFile;

import java.io.File;
import java.io.IOException;
import org.apache.log4j.Logger;

/**
 * ResourceLoader.
 *
 * @author christopher-johnson
 */
public class ResourceLoader {
    private static Logger logger = getLogger(ResourceLoader.class);

    public static MetsData getMets(String sourceFile) throws IOException {
        return getMetsFromFile(sourceFile);
    }

    public static MetsData getMetsAnchor(String sourceFileUri) throws IOException {
        File metsFile = new File(sourceFileUri);
        if (metsFile.exists()) {
            String anchorFileName = metsFile.getName();
            int pos = anchorFileName.lastIndexOf(".");
            String anchorBaseName = null;
            if (pos > 0) {
               anchorBaseName = anchorFileName.substring(0, pos); 
            }
            String anchorPath = metsFile.getParent() + "/" + anchorBaseName + "_anchor.xml";
            File anchorfile = new File(anchorPath);
            if (anchorfile.exists()) {
                return getMetsFromFile(anchorfile);
            }
        }
        return null;
    }
}
