#define MAX 1000
void PreOrder(struct TreeNode* root, int* array, int* returnSize){
    if(root){
        array[(*returnSize)++] = root->val;
        PreOrder(root->left, array, returnSize);
        PreOrder(root->right, array, returnSize);
        }
    array[*returnSize]='\0';
}

int* preorderTraversal(struct TreeNode* root, int* returnSize){
    *returnSize = 0;
    int *array = (int*)malloc(sizeof(int) * MAX);
    PreOrder(root, array, returnSize);
    return array;
}
