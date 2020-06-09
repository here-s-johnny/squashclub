package pl.s18280.squashclub.common.aggregates;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.s18280.squashclub.common.valueobject.Hour;

import java.util.Set;

@AllArgsConstructor
@Data
public class Hours {
    private Set<Hour> hours;
}
