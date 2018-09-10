
#include "Candidato.h"
using namespace std;

class NoCandidato{
    public:
        Candidato* conteudo;
        NoCandidato* next;
            
    NoCandidato(Candidato* _conteudo=NULL, NoCandidato* _next=NULL){
        conteudo = _conteudo;
        next=_next;
    }
    NoCandidato(NoCandidato* _NoCandidato){
        conteudo=_NoCandidato->conteudo;
        next=_NoCandidato->next;
    }

    ~NoCandidato(){
        conteudo->~Candidato();
    }

    string toString(){
        stringstream stream;
        NoCandidato* read=this;
            while(read!=NULL){
                stream << read->conteudo->toString() << " -> ";
                read=read->next;
            }
            stream<<"0";
        return stream.str();
    }


};