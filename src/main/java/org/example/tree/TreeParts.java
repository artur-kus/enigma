package org.example.tree;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TreeParts {
    private List<Branch> branch;
    private Trunk trunk;
    private Long roots;

    private int branchSize(){
        return branch.size();
    }
}
