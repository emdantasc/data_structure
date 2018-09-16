#include <cstring>
#include <fstream>
#include <iostream>
#include"NoCandidato.h"

class ListaCandidatos{
    public:
        NoCandidato* head;

    ListaCandidatos(NoCandidato *_NoCandidato=NULL){head=_NoCandidato;}
    
    ListaCandidatos(string Archive){
        ifstream fcin(Archive);
        string dados;
        getline(fcin,dados);
        cout<<"Criacao da lista de candidatos de: "<<dados<<endl;

        while(getline(fcin, dados)){
            adicioneComoHead(new Candidato(dados));
        }
    }

    bool estaVazia(){
        if(this->head==NULL){
            return true;
        }
        else{return false;}
    }
    
    void adicioneComoHead(Candidato* _Candidato){
       if(estaVazia()){
           this->head=new NoCandidato(_Candidato, NULL);   
       }
       else{
           this->head=new NoCandidato(_Candidato, this->head);
       }
        return;
    }

    int tamanho(){
        NoCandidato* it=this->head;
        int count=0;

        while(it!=NULL){
            it=it->next;
            count++;
        }
        return count;
    }

    bool remove(string _nome, string _sobrenome){
        NoCandidato* it=this->head;
        NoCandidato* last=NULL;

            while(it!=NULL){
                if((it->conteudo->igual(_nome, _sobrenome)) && last==NULL){
                    this->head=it->next;
                    delete it;
                    return true;
                }
                else if((it->conteudo->igual(_nome, _sobrenome)) && last!=NULL){
                    last->next=it->next;
                    delete it;
                    return true;
                }
                else if((it->conteudo->igual(_nome, _sobrenome)) && (it->next==NULL)){
                    last->next=NULL;
                    delete it;
                    return true;
                }
                else{
                    last=it;
                    it=it->next;
                }
            }

        return false;
    }

    void filtrarCandidatos(const int _nota){
        NoCandidato* it=head, to_delete, last=NULL;
        
        while(it!=NULL){
            if((*it->conteudo->nota<_nota) && last==NULL){
                head=it->next;
                last=NULL;
                to_delete=it;
                it=it->next;
            }
            else if((*it->conteudo->nota<_nota) && last!=NULL){
                last->next=it->next;
                to_delete=it;
                it=it->next;
            }
            else if((*it->conteudo->nota<_nota) && it->next==NULL){
                last->next=NULL;
                to_delete=it;
                it=NULL;
            }
            else{
                last=it;
                it=it->next;
            }
            delete to_delete;
        }
        return;
    }

    void concatena(ListaCandidatos* list){
        NoCandidato* it=head;
        bool stop=false;

        while(!stop){
            if(it->next==NULL){
                it->next=list->head;
                stop=true;
            }
            else{it=it->next;}
        }
        return;
    }

    string toString(){
        stringstream stream;
        if(estaVazia()){
            stream << "0";
        }
        else{
            stream << this->head->toString();
        }
        return stream.str();
    }

};