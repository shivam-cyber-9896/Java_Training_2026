package com.shivam.monocept.collectionassingment.model1;


import java.util.Comparator;

public class CandidateComparator implements Comparator<CandidatesComparable>{
     
    @Override
    public int compare(CandidatesComparable c1, CandidatesComparable c2)
    {
        int nameCompare = c1.getName().compareTo(c2.getName());

        if(nameCompare != 0)
            return nameCompare;

        return c1.getAge() - c2.getAge();
    }
}