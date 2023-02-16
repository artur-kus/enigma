package org.example.tree;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.helper.GeneralUtil;

@Data
@NoArgsConstructor
public class AdvancedSpecification {
    private int age;
    private Location location;
    private Dimension dimension;

    private boolean hasLocation() {
        return location != null && !GeneralUtil.isNullOrEmpty(location.getLongitude())
                && !GeneralUtil.isNullOrEmpty(location.getLatitude());
    }
}
