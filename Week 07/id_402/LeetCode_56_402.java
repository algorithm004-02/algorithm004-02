//工程中层用到过类似问题，但稍微有些复杂，输入有[A1-A3],[A1-A9],[A41-A48],[B1-B3],[B4-A5]
//其外层还有分类，只抽出核心，最后输出 [A1-A9][A41-48][B1-B5] 
public class CaseNum  {
    private Integer begin;
    private Integer end;
    private String caseNum;

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }

    @Override
    public String toString() {
        return "CaseNum{" +
                "begin=" + begin +
                ", end=" + end +
                ", caseNum='" + caseNum + '\'' +
                '}';
    }


}


    /**
     * 数箱方法
     * 相同字头数箱结果
     * @param list
     * @return
     */
    public static String result(List<CaseNum> list){
        String str = null;
        //排序
        LinkedList<CaseNum> merged = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(CaseNum c : list){
            set.add(c.getBegin());
        }
        Iterator<Integer> judgeSetIter = set.iterator();
        LinkedList<CaseNum> newList = new LinkedList<>();
        while(judgeSetIter.hasNext()){
            CaseNum temp = null;
            Integer beginSet = judgeSetIter.next();
            for(CaseNum caseNum: list){
                if(caseNum.getBegin().equals(beginSet)){
                    if(temp == null || temp.getEnd() < caseNum.getEnd()){
                        temp = caseNum;
                    }
                }
            }
            newList.add(temp);
        }
        Collections.sort(newList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((CaseNum) o1).getBegin() - ((CaseNum) o2).getBegin();
            }
        });
        //核心代码
		//----------------------------------------------
        for (CaseNum caseNum : newList) {
            if(merged.isEmpty() || merged.getLast().getEnd() < caseNum.getBegin() - 1){
                merged.add(caseNum);
            }else{
                merged.getLast().setEnd(Math.max(merged.getLast().getEnd(),caseNum.getEnd()));
            }
        }
		//-------------------------------------------
        StringBuilder resStrSB = new StringBuilder();
        Collections.sort(merged, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                char[] chars1=((CaseNum) o1).getCaseNum().toCharArray();
                char[] chars2=((CaseNum) o2).getCaseNum().toCharArray();
                int i=0;
                while(i<chars1.length && i<chars2.length){
                    if(chars1[i]>chars2[i]){
                        return -1;
                    }else if(chars1[i]<chars2[i]){
                        return 1;
                    }else{
                        i++;
                    }
                }
                if(i==chars1.length){  //o1到头
                    return 1;
                }
                if(i== chars2.length){ //o2到头
                    return -1;
                }
                return 0;
            }
        });
        for (int i = 0; i < merged.size(); i++) {
            Integer begin = merged.get(i).getBegin();
            Integer end = merged.get(i).getEnd();
            String num = merged.get(i).getCaseNum();
            resStrSB.append(num).append(begin).append("-").append(num).append(end);
            if(i < merged.size() -1 ){
                resStrSB.append(",");
            }
        }
        return resStrSB.toString();
    }
