int minimumTotal(int** triangle, int triangleSize, int* triangleColSize){
    int i = 0,j = 0,tmp = 0;
for(i = triangleSize - 2;i >= 0; i--) {
tmp = i + 1;
for(j = 0;j < tmp; j++) {
if(triangle[i+1][j] < triangle[i+1][j+1]) {
triangle[i][j] += triangle[i+1][j];
}
else {
triangle[i][j] += triangle[i+1][j+1];
}
}
}
return triangle[0][0];
}