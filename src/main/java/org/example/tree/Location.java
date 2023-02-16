package org.example.tree;

import com.sun.jdi.InternalException;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.helper.GeneralUtil;

@Data
@NoArgsConstructor
public class Location {
    private String latitude;
    private String longitude;

    private void locationChecker() {
        if (GeneralUtil.isNullOrEmpty(latitude)) throw new InternalException("empty.latitude");
        if (GeneralUtil.isNullOrEmpty(longitude)) throw new InternalException("empty.longitude");
    }

    public String getLocation() {
        locationChecker();
        return "Co-ordinates: " + longitude + " " + latitude;
    }
}
