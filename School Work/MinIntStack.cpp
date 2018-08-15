#include <string>
#include <stack>
#include <iostream>

using namespace std;
//node class
class Node
{
    
public:
    int data;
    Node *next;
    
    //Constructor
    Node(int d)
    {
        data = d;
        next = nullptr;
    }
};

//minintstack class
class MinIntStack
{
private:
    int min;
    stack<int> minStack;
    Node *top;

    string printRec(Node* n)//prints recursively until null
    {
        string s = "    ";
        if (n == nullptr)
            return s;
        else {
            s = to_string(n->data) + " " + printRec(n->next);
            return s;
        }
    }
    
public:
    
    //constructor
    MinIntStack()
    {
        top = nullptr;
    }
    
    //deconstructor
    ~MinIntStack()
    {
        while (top != nullptr)
            pop();
    }
    
    MinIntStack(int i)
    {
        top = new Node(i);    }
    
    //push function
    void push(int i)
    {
        if(top!=nullptr)
        {
            if (i < top->data)
            {
                minStack.push(i);
                Node *temp = new Node(i);
                temp->next = top;
                top = temp;
            }
            
            else
            {
                Node *temp = new Node(i);
                temp->next = top;
                top = temp;
            }
        }
        else{
            minStack.push(i);
            Node *temp = new Node(i);
            temp->next = top;
            top = temp;
            
        }
    }
    //pop function
    int pop()
    {
        if (top != nullptr)
        {
            if (top->data == minStack.top())
            {
                minStack.pop();
            }
            Node *temp = top;
            top = top->next;
            int d = temp->data;
            delete temp;
            return d;
            
        }
        else
            return -1;
    }
    
    int getMin()
    {
        return min;
    }
    
    
    string print()
    {
        return printRec(top);
    }
    
    
};

//main
using namespace std;
int main()
{
    
    MinIntStack s;
    
    cout << "Min Int Stack" << endl;
    
   s.push(3);
    
    s.push(4);
    
    s.push(2);
    
   s.push(2);
    
    cout << s.getMin() << endl; //Should output 2
    
    s.pop();
    
    cout << s.getMin() << endl; //Should output 2
    
    s.pop();
    
    cout << s.getMin() << endl; //Should output 3
    

    
    return 0;
    
}

