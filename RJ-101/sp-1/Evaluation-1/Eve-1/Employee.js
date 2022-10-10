class Employee{
    constructor(){

    }

    Employee(json){
        this.currentPage=json.currentPage;
        this.data=json.data;
    }

    get currentPage(){
        return this.#currentPage;
    }

    get currentPage(){
        return this.#data;
    }

   
}