function init(getMemberList) {
    var inners = "";
    getMemberList.sort(function(arr1, arr2){
        var str1 = arr1.name.toLowerCase();
        var str2 = arr2.name.toLowerCase();
        if (str1 > str2) {
            return 1;
        } else {
            return -1;
        }
    });
    for(var i = 0;i<getMemberList.length;i++){
        inners = "<tr>\n" +
            "<th>" + getMemberList[i].name + "</th>\n" +
            "<th>" + getMemberList[i].age + "</th>\n" +
            "<th>" + getMemberList[i].registerDate + "</th>\n" +
            "</tr>\n";
    }
}

function updateTable(sortBy) {
    var inners = "";
    getMemberList.sort(function(arr1, arr2){
        var str1 = arr1.name.toLowerCase();
        var str2 = arr2.name.toLowerCase();
        if (str1 > str2) {
            return 1;
        } else {
            return -1;
        }
    });
    for(var i = 0;i<getMemberList.length;i++){
        inners = "<tr>\n" +
            "<th>" + getMemberList[i].name + "</th>\n" +
            "<th>" + getMemberList[i].age + "</th>\n" +
            "<th>" + getMemberList[i].registerDate + "</th>\n" +
            "</tr>\n";
    }
}
