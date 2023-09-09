<template>
    <div class="container">
        <div class="split left">
            <div class="top">
                <h1 class="letter">{{ this.letter.name }}  </h1>
            </div>
            <div class="bottom">
               <div class="search">
                <input type="text" class="searchInput" placeholder="Пребарај збор"/>
               </div>
               <div>
                <select name="words" id="words" class="wordsDropdown"  @change="getSelectedWordId($event)" >
                    <option v-for="word in words" v-bind:key="word.id" v-bind:value="word.id">{{word.word}}</option>
                </select>
               </div>
            </div>
        </div>
        <div class="split right">
            <div>
                <WordComponent  :wordId="selectedWordId" :letter="this.letter" :word="this.word" :definitions="this.definitions"></WordComponent>
            </div>
        </div>
    </div>
</template>

<script>
import WordComponent from './WordComponent.vue';

    export default{
    name: "LetterWithWordsComponent",
    data() {
        return {
            name: this.$route.params.l,
            w: this.$route.params.w + " " + this.$route.params.t+'.',
            letter: null,
            words: [],
            selectedWordId: 0,
            word:null,
            definitions:[]
            
        };
    },
    methods: {
        async getLetter() {
            const letterApi = await fetch('http://localhost:9090/api/letters/byName/' +this.name);
            const result = await letterApi.json();
            this.letter = result;
        },
        async getWords() {
            const wordsApi = await fetch('http://localhost:9090/api/letters/' + this.letter.id + '/words');
            const result = await wordsApi.json();
            this.words = result;
            
            if(this.w != 'undefined undefined.'){
                const wordApi = await fetch('http://localhost:9090/api/letters/' + this.letter.id + '/words/byWord/' + this.w);
                const result3 = await wordApi.json();
                this.word = result3;
                this.selectedWordId = result3.id;      
                console.log(this.selectedWordId)          
                const definitionsApi = await fetch('http://localhost:9090/api/letters/' + this.letter.id + '/words/' + result3.id +"/definitions");
                const result4 = await definitionsApi.json();
                this.definitions = result4;
            }else{
                this.word=result[0];
                this.selectedWordId = result[0].id;
                const definitionsApi = await fetch('http://localhost:9090/api/letters/' + this.letter.id + '/words/' + result[0].id +"/definitions");
                const result2 = await definitionsApi.json();
                this.definitions = result2;
            }
            
        },
        async getSelectedWordId(event){
                this.selectedWordId =  event.target.value;
                const wordApi = await fetch('http://localhost:9090/api/letters/' + this.letter.id + '/words/' + event.target.value);
                const result = await wordApi.json();
                this.word = result;
                const definitionsApi = await fetch('http://localhost:9090/api/letters/' + this.letter.id + '/words/' + event.target.value +"/definitions");
                const result2 = await definitionsApi.json();
                this.definitions = result2;
                // const routeString = this.word.word.split(" ");
                // const part1 = routeString[0];
                // let part2 = '';
                // if(routeString. > 2)
                //     part2 = routeString[1]+ routeString[2]+ routeString[3];
                // else
                //     part2 = routeString[1];
                // console.log(part2)
                // this.$router.push(this.letter.name+'.'+part1+"/"+part2);
                // this.$route.fullPath()
            }           
         
    },
    computed:{
       
    },
    beforeMount(){
        this.getLetter();
        this.getWords();
    },
    components:{
        WordComponent
    }
}

</script>

<style scoped>
.container {
    height: 80vh;
}

.letter{
    background-color: whitesmoke;
    display: inline-block;
    min-width: 80px;
    padding: 40px;
    margin-top: 98px;
    font-size:xx-large;
    font-size: 50px;
    color: #89621c;
    box-shadow: 5px 5px 10px 0px;;
    border-bottom: 1px solid #bb8a36;
    border-radius: 30px;
}
.left {

  display: block;
  float: left;
  width: 30%;
  height: 100%;
}

.right {
    display: block;
  /* background-color: #22a30b; */
  float: left;
  width: 70%;
  height: 100%;
}

.top{
    height: 35%;
    width: 100%;
    
}

.bottom{
    height: 65%;
    /* background-color: pink; */
}

.wordsDropdown{
    font-size:xx-large;
    font-size: 20px;
    color: #89621c;
    box-shadow: 5px 5px 10px 0px;;
    border-bottom: 1px solid #bb8a36;
    border-radius: 30px;
    background-color: whitesmoke;
    text-align: center;
    width: 280px;
}

.searchInput{
    font-size: 17px;
    box-shadow: 5px 5px 10px 0px;
    border-bottom: 1px solid #bb8a36;
    border-radius: 30px;
    background-color: whitesmoke;
    text-align: center;
    width: 272px;
    height: 22px;
    margin-bottom: 10px;
}

</style>