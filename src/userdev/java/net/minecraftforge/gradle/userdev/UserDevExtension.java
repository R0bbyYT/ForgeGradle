/*
 * ForgeGradle
 * Copyright (C) 2018 Forge Development LLC
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 */

package net.minecraftforge.gradle.userdev;

import net.minecraftforge.gradle.common.util.MappingFile;
import net.minecraftforge.gradle.common.util.MinecraftExtension;
import org.gradle.api.Project;

import javax.annotation.Nonnull;

public class UserDevExtension extends MinecraftExtension {

    public static final String EXTENSION_NAME = "minecraft";

    private MappingFile.Mapping reobfMappings = MappingFile.Mapping.SEARGE;

    public UserDevExtension(@Nonnull final Project project) {
        super(project);
    }

    @Override
    public void mappings(@Nonnull String channel, @Nonnull String version) {
        setMappings(channel + "_" + version);
    }

    public void setReobfMappings(String mappings) {
        this.reobfMappings = MappingFile.Mapping.get(mappings);

        if (this.reobfMappings == null || this.reobfMappings == MappingFile.Mapping.MCP) {
            throw new IllegalArgumentException("Mapping type must be either SEARGE or NOTCH");
        }
    }

    public MappingFile.Mapping getReobfMappings() {
        return this.reobfMappings;
    }
}
