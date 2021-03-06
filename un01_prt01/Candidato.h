#ifndef _CANDIDATO_H
#define _CANDIDATO_H
#include <cstring>
#include <sstream>

using namespace std;

class Candidato{

 public:

  string* sobrenome;
  string* nome;
  int* nota;


  Candidato(string linha){
    sobrenome = new string;
    nome= new string;
    nota= new int;
    stringstream stream(linha);
    stream >> *sobrenome >> *nome >> *nota;
  }

  ~Candidato(){
    delete nome;
    delete sobrenome;
    delete nota;
  }

  string toString(){
     stringstream stream;
     stream << *sobrenome << " " << *nome << " " << *nota; 
     return stream.str();
  }

  bool igual(string n, string s){
    
    if(*sobrenome == s && *nome == n) return true;
    else return false;
  }

};
#endif
